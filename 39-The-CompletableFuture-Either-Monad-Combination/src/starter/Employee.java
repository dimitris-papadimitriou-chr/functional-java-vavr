package starter;
public class Employee {
    private Integer id;
    private String name;

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }  // constructor

    // Getter Methods

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Setter Methods

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}

