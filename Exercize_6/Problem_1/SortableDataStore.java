package Exercize_6.Problem_1;

public class SortableDataStore implements Comparable<SortableDataStore> { 
    protected String productItem, noItem, orderInfo;
    public SortableDataStore() {
        productItem = null;  
        noItem = null; 
        orderInfo = null; 
    }
    public SortableDataStore(String p, String n, String o) {
        productItem = p;  
        noItem = n; 
        orderInfo = o; 
    }

    public String toString() {
        return new String(productItem + ", " + noItem + ", " + orderInfo) ;
    }

    public int compareTo(SortableDataStore s) {
        if (this.productItem.compareTo(s.productItem) != 0) {
            return this.productItem.compareTo(s.productItem);
        } else if (this.noItem.compareTo(s.noItem) != 0) {
            return this.noItem.compareTo(s.noItem);
        } else {
            return this.orderInfo.compareTo(s.orderInfo);
        }
    }
}
    

