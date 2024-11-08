import java.net.Inet4Address;

public class Controller {
    private final Service service;
    public Controller(Service service){
        this.service = service;
    }

    public void createLoggedInCustomer(String name, String address, String phone, String email){
        Integer Id = service.getNewCustomerId();
        service.createCustomer(Id, name, address, phone, email);
    }

    public void createLoggedInEmployee(Integer departmentId, String name, String phone, String license){
        Integer Id = service.getNewEmployeeId();
        service.createEmployee(Id, departmentId, name, phone, license);
    }

    /*
    alex
     */
//    public void createLoggedInDeliveryPerson(Integer departmentId, String name, String phone, String license){
//        Integer Id = service.getNewEmployeeId();
//        service.createEmployee(Id, departmentId, name, phone, license);
//    }

    public void createStore(String name, String address, String contact){
        Integer Id = service.getNewStoreId();
        service.registerShop(Id, name, address, contact);
    }


}
