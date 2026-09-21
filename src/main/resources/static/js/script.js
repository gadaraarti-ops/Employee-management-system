function saveEmployee() {

    const employee = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        department: document.getElementById("department").value,
        salary: document.getElementById("salary").value
    };

    fetch("http://localhost:8080/employee/save", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(employee)
    })
    .then(response => response.json())
    .then(data => {
        alert("Employee Saved Successfully!");
        console.log(data);
    })
    .catch(error => {
        console.error(error);
        alert("Error while saving employee.");
    });

}