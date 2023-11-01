console.log("Test");

let userr = document.getElementById("userr")
let password = document.getElementById("password")
let loginBtn = document.getElementById("loginBtn");

let user="admin";
let pass="admin";

loginBtn.addEventListener("click", () =>{

    if (userr.value == user && password.value == pass){
        localStorage.setItem("user", "admin");
        localStorage.setItem("pass", "admin");
        alert("Lyckad inloggning");
        window.location.assign('http://localhost:8080/');
   
         console.log(user + pass);
    }
    else{
        alert("Fel användarnamn eller lösenord")
    }
    
})


