let User = document.getElementById("User")
let password = document.getElementById("password")
let loginBtn = document.getElementById("loginBtn");

let user="admin";
let pass="admin";

loginBtn.addEventListener("click", () =>{
    login();
})

function login(){
    if (User.value == user && password.value == pass){
        localStorage.setItem("user", "admin");
        localStorage.setItem("pass", "admin");
        alert("Lyckad inloggning");
        window.location.assign('http://localhost:8080/');
    }
    else{
        alert("Fel användarnamn eller lösenord")
    }
}