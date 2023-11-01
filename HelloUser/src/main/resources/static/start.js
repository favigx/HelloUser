localStorage.getItem("user");
localStorage.getItem("pass");

let loginLink = document.getElementById("lank");
let List = document.getElementsByClassName("List");

if (localStorage.getItem("user")){
    console.log("LS existerar")
    
  
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


if (localStorage.getItem("user")){
    let link = document.createElement("a");
    link.innerText = "Lägg till medlem"
    link.href="/addmember"
    document.body.appendChild(link);
    link.style.fontSize = "17px";
    link.style.fontFamily = "monospace"
}


if(!localStorage.getItem("user")){
    for (let i = 0; i < List.length; i++) {
    removeBtn.remove();
}
      
}

