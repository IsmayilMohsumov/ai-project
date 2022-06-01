let btn = document.querySelector("#btn");
let sidebar = document.querySelector(".sidebar");

btn.onclick = function () {
    sidebar.classList.toggle("active");
}

const searchbtn = document.querySelector(".searchbox__icon");
const searchboxinput = document.querySelector(".searchbox__input");

searchbtn.addEventListener("click",()=>{
    searchboxinput2.classList.toggle("actived"); 
    console.log("ok");
  })

const body = document.querySelector("body"),
      nav =  document.querySelector(".header"),
      darkModeToggle = document.querySelector(".dark-light");

      darkModeToggle.addEventListener("click",()=>{
        darkModeToggle.classList.toggle("actived"); 
        body.classList.toggle("dark"); 
      })
      



// document.querySelector(".maintable").addEventListener("click", () => {
//     sidebar.classList.remove("active");
// })

const formPp = document.querySelector(".create__upload__pp");

const img = document.querySelector("#photo");

const file = document.querySelector("#file");

const uploadBtn = document.querySelector("#uploadBtn");

//if user hover on profile photo
formPp.addEventListener("mouseenter", function () {
    uploadBtn.style.display = "flex";
})

//if user hover out from formPp div

formPp.addEventListener("mouseleave", function () {
    uploadBtn.style.display = "none";
})

file.addEventListener("change", function () {
    const choosedFile = this.files[0];

    if (choosedFile) {
        const reader = new FileReader();

        reader.addEventListener("load", function () {
            img.setAttribute("src", reader.result);
        });

        reader.readAsDataURL(choosedFile);
    }
})

const showbtn = document.querySelector(".showbtn")

const showInputs = document.querySelectorAll(".showinput")

showbtn.onclick = function (e) {
    const isLess = e.target.getAttribute("data-is-less") == "false";

    showbtn.setAttribute("data-is-less", isLess ? true : false);

    showbtn.innerText = isLess
        ? "Show less"
        : "Show more";

    showInputs.forEach(showInput => showInput.classList.toggle("active"))
}
// init plugin
var input = document.querySelector("#phone-picker");
window.intlTelInput(input, {
    utilsScript: "node_modules/intl-tel-input/build/js/utils.js?22",
    separateDialCode: true,
    preferredCountries: ['az']
});


function myPrint(maintable){
    var printdata = document.getElementById(maintable);
    window.print();
   
}

