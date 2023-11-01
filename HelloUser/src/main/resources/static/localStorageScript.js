localStorage.getItem("user");
localStorage.getItem("pass");

let loginLink = document.getElementById("loginLink");
let List = document.getElementsByClassName("List");
let addmemberLink = document.getElementById("addmemberLink");

if (localStorage.getItem("user")){
    logOut();
}

if(!localStorage.getItem("user")){
    hideRemoveBtn();
    hideAddmemberLink();
}

function logOut(){

    loginLink.innerText = "Logga ut";
        
        if(loginLink.innerText == "Logga ut"){

            loginLink.addEventListener("click", () =>{
                localStorage.removeItem("user");
                localStorage.removeItem("pass");
                alert("Du är nu utloggad.");
                window.location.assign('http://localhost:8080/');
            })
        }
}

function hideRemoveBtn(){

    for (let i = 0; i < List.length; i++) {
        removeBtn.remove();
    }
    
}

function hideAddmemberLink(){
    addmemberLink.remove();
}

// if (localStorage.getItem("user")){
//     let link = document.createElement("a");
//     link.innerText = "Lägg till medlem"
//     link.href="/addmember"
//     document.body.appendChild(link);
//     link.style.fontSize = "17px";
//     link.style.fontFamily = "monospace"
// }