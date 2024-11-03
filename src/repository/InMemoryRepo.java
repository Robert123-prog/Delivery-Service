package repository;

import model.Customer;
import model.Delivery;

public class InMemoryRepo<T> implements IRepository{
    @Override
    public void create() {
        //user input needed in order to create any type of object
        /*
        prompt user with what type of object to create
         */
    }

    @Override
    public void read(Object obj) {
        System.out.println(obj.toString());
    }

    @Override
    public void update(Object obj) {
        //user input needed in order to update any type of object
        /*
        prompt user with what type of object to update
         */
    }

    @Override
    public void delete(Object obj) {
        //user input needed in order to delete any type of object
        /*
        prompt user with what type of object to delete
         */
    }
}
