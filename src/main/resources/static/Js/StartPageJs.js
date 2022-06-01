
const Header = document.querySelector(".Startheader");

window.addEventListener('scroll',checkHeightHeader);

function checkHeightHeader(){
    
    if(window.scrollY>200){
        Header.style.backgroundColor = "rgba(36, 54, 94, 0.85)";
    }else{
        Header.style.backgroundColor = "transparent";
    }
}

const goTopBtn = document.querySelector(".topBtn");
window.addEventListener('scroll',checkHeight)

function checkHeight(){
    if(window.scrollY>200){
        goTopBtn.style.display = "block"
    }else{
        goTopBtn.style.display = "none"
    }
}

goTopBtn.addEventListener("click",()=>{
    window.scrollTo({
        top:0,
        behavior:"smooth"
    })
})