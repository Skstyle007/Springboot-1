const form = document.getElementById("studentForm");

form.addEventListener("submit", function(event){

    event.preventDefault();

    const student = {

        id: document.getElementById("id").value,

        name: document.getElementById("name").value,

        age: document.getElementById("age").value,

        department: document.getElementById("department").value

    };

    fetch("http://localhost:8080/create",{

        method:"POST",

        headers:{
            "Content-Type":"application/json"
        },

        body:JSON.stringify(student)

    })

        .then(response=>response.json())

        .then(data=>{

            document.getElementById("message").innerHTML="Student Saved Successfully";

            console.log(data);

        })

        .catch(error=>{

            console.log(error);

        });

});