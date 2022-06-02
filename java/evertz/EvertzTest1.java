package evertz;

public class EvertzTest1 {
    /*public static void main(String[] args) {


        //order by salary
        //Group by department
        String s = "SELECT e.name, MAX(salary) FROM employee e"
                + "INNER JOIN department d on e.dept_id = d.id"
                + "GROUP BY d.id";
    }

    @RunWith(SpringJUnitRunner.class)
    class EmployeeServiceTest {

        @InjectMock
        private EmployeeService employeeService;

        @Mock
        private EmployeeRepo employeeRepo;

        @Test
        public void shouldAbleToReturnHighestPaidEmployeeByEachDepartment() {
            //Given
            when(employeeRepo.findHighestPaidEmployeeByDepartment()).thenReturn(new Employee(1, "test"));

            //When
            Employee highestPaidEmployeeByDepartment = employeeService.findHighestPaidEmployeeByDepartment();

            //Then
            assertNotNull(highestPaidEmployeeByDepartment);
            assertEquals("test", highestPaidEmployeeByDepartment.name);
            assertEquals("1", highestPaidEmployeeByDepartment.id);
        }
    }

    @Service
    class EmployeeService {

        @Autowired
        EmployeeRepo employeeRepo;

        Employee findHighestPaidEmployeeByDepartment() {
            return this.employeeRepo.findHighestPaidEmployeeByDepartment();
        }

    }*/


    interface EmployeeRepo {
        Employee findHighestPaidEmployeeByDepartment();
    }

    class Employee {
        Integer id;
        String name;

        Employee(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }

}
