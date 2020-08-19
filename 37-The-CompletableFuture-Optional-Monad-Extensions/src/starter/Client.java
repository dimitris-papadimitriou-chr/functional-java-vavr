package starter;
public class Client {
    private Integer id;
    private String name;
    private Integer employeeId;

    public Client(Integer id,
                  String name,
                  Integer employeeId) {
        this.id = id;
        this.name = name;
        this.employeeId = employeeId;
    }  // constructor

    // Getter Methods

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }    // Setter Methods

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

}

