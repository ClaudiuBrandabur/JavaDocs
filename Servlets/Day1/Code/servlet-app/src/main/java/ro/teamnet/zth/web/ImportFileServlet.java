package ro.teamnet.zth.web;

import javax.script.ScriptContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO Write javadoc
 */
@MultipartConfig
public class ImportFileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO 1: Obtain the username from the request instance
        String user = request.getParameter("user");

        // Obtain the File object from the request instance
        Part file = request.getPart("uploadFile");

        // read the lines from CSV file and print the values
        // TODO 2: Replace T with Person
        List<Person> personsFromFile = readLines(file);
        personsFromFile.stream();


        // Set the response type
        response.setContentType("text/html");

        // TODO 6: Print a nice message to the response so the user will be notified of the result
        // TIP: The final text printed on the response should be something like this: "Hello <username>! You successfully imported 4 people. "
        //HttpServletResponse response = null;
        PrintWriter PrintWriter = response.getWriter();
        PrintWriter.write("<h1>" + "Hello " + user +
                "! You successfully imported 4 people." + "</h1>");

        for (Person index: personsFromFile) {
            PrintWriter.write("<p>" + index.toString() + "</p>");
        }

//        PrintWriter.write("First Name | " + " Last Name | " + " Age | " + " Married");
//        for (Person index: personsFromFile) {
//            PrintWriter.write("<p>" + index.getFirstName() + " | " +
//                                        index.getLastName() + " | " +
//                                        index.getAge() + " | " +
//                                        index.getMarried() + "</p>");
//        }


    }

    /**
     * TODO write javadoc
     * @param file
     * @return
     */
    private List<Person> readLines(Part file) throws IOException {
        List<Person> persons = new ArrayList<>();

        //BufferedReader bufferedReader = null;

        // TODO 3: Replace with try-with-resources

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream()))){

            Stream<String> allLines = bufferedReader.lines();
            persons = allLines.map(line -> line.split(","))
                    .map(pers -> new Person(pers[0],pers[1],Long.valueOf(pers[2]),Boolean.valueOf(pers[3])))
                    .collect(Collectors.toList());

            } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO 4: Iterate through the lines of the reader using java streams.
        // TIP: Use map to get the current line
        // TIP: Use split() method for each line (check API documentation)
        // TIP: For Long and Boolean fields you should use valueOf() method
        // TIP: Use Collectors to return a List

        // after implementing the list, let's print it. It will print nicely if you have overridden the toString() method ;)
        persons.forEach(System.out :: println);

//        TODO 5: Sort the persons list by their age field
        // TIP: use lambda expression (only one line of code is needed to complete this step)
        persons = persons.stream().sorted(Comparator.comparingLong(pers -> pers.getAge())).collect(Collectors.toList());
        // let's print again to check if it's sorted
        persons.forEach(System.out :: println);

        return persons;
    }

    private class Person {

        private String firstName;
        private String lastName;
        private Long age;
        private Boolean married;

        public Person(String firstName, String lastName, Long age, Boolean married) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.married = married;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Long getAge() {
            return age;
        }

        public void setAge(Long age) {
            this.age = age;
        }

        public Boolean getMarried() {
            return married;
        }

        public void setMarried(Boolean married) {
            this.married = married;
        }

        @Override
        public String toString() {
            return  "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    ", married=" + married + "\n";
        }
    }

}
