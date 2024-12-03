package service;

import model.Delivery;
import model.Delivery_Person;
import model.Personal_Vehicle;
import repository.IRepository;

import java.util.List;
import java.util.stream.Collectors;

public class DeliveryPersonService {
    private final IRepository<Delivery> deliveryIRepository;
    private final IRepository<Delivery_Person> deliveryPersonIRepository;
    private final IRepository<Personal_Vehicle> personalVehicleIRepository;


    public DeliveryPersonService(IRepository<Delivery> deliveryIRepository, IRepository<Delivery_Person> deliveryPersonIRepository, IRepository<Personal_Vehicle> personalVehicleIRepository){
        this.deliveryIRepository = deliveryIRepository;
        this.deliveryPersonIRepository = deliveryPersonIRepository;
        this.personalVehicleIRepository = personalVehicleIRepository;
    }

    public List<Delivery> getDelivery() {
        return deliveryIRepository.readAll();
    }

    public Integer getNewDeliveryPersonId() {
        int maxId = 0;
        for (Integer Id : deliveryPersonIRepository.getKeys()) {
            if (Id.compareTo(maxId) > 0) {
                maxId = Id;
            }
        }
        return maxId + 1;
    }

    /**
     * Registers a new delivery person in the system
     *
     * @param deliveryPersonId Unique identifier for the delivery person
     * @param name Full name of the delivery person
     * @param phone Contact phone number
     * @param license Driver's license number
     */
    public void enrollAsDriver(Integer deliveryPersonId, String name, String phone, String license) {
        // Create a new DeliveryPerson instance
        Delivery_Person deliveryPerson = new Delivery_Person(deliveryPersonId,name,phone);
        // Add the DeliveryPerson instance to both repositories if needed
        deliveryPerson.setVerified(true);
        deliveryPersonIRepository.create(deliveryPerson);
        //employeeIRepository.create(deliveryPerson);
    }

    /**
     * Retrieves a list of deliveries that contain at least one order with the status "to be shipped".
     *
     * @return a list of deliveries where at least one order is marked with the status "to be shipped".
     */
    public List<Delivery> getDeliveriesWithToBeShippedOrders() {
        List<Delivery> allDeliveries = deliveryIRepository.readAll();

        return allDeliveries.stream()
                .filter(delivery -> delivery.getOrders().stream()
                        .anyMatch(order -> "to be shipped".equalsIgnoreCase(order.getStatus())))
                .collect(Collectors.toList());
    }

    public void pickDeliveryToPerson(Integer deliverPersonId, Integer deliveryId) {
        Delivery delivery = deliveryIRepository.get(deliveryId);
        Delivery_Person deliveryPerson = deliveryPersonIRepository.get(deliverPersonId);
        if (delivery != null && deliveryPerson != null) {
            deliveryPerson.addDelivery(delivery);
            deliveryPersonIRepository.update(deliveryPerson);
            delivery.setDeliveryPeronID(deliverPersonId);
            deliveryIRepository.update(delivery);
        }
    }

    /**
     * Assigns a personal vehicle to a delivery person
     *
     * @param deliveryPersonId ID of the delivery person
     * @param personalVehicleId ID of the personal vehicle to assign
     */
    public void assignPersonalVehicle(Integer deliveryPersonId, Integer personalVehicleId){
        Delivery_Person deliveryPerson = deliveryPersonIRepository.get(deliveryPersonId);
        Personal_Vehicle personalVehicle = personalVehicleIRepository.get(personalVehicleId);

        //deliveryPerson.setPersonalVehicleId(personalVehicleId);
        personalVehicle.setDeliveryPersonID(deliveryPersonId);
        deliveryPerson.setPersonalVehicleId(personalVehicleId);
        //deliveryPersonIRepository.update(deliveryPerson);
        personalVehicleIRepository.update(personalVehicle);
    }

    public List<Delivery> getDeliveriesForDeliveryPerson(Integer deliveryPersonId) {
        Delivery_Person deliveryPerson = deliveryPersonIRepository.get(deliveryPersonId);
        return deliveryPerson.getDeliveries();
    }

    public List<Delivery_Person> getDeliveryPerson() {
        return deliveryPersonIRepository.readAll();
    }
}
