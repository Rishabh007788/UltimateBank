var balance = document.getElementById("check-bal-btn");
var trans = document.getElementById("money-trans-btn");
var passbook = document.getElementById("passbook-btn");
var checkbal = document.getElementById("checkbal-form");
var moneytrans = document.getElementById("moneytrans-form");
var passform = document.getElementById("passbookform");

balance.addEventListener("click",
        ()=>{
            checkbal.classList.toggle("check-bal-form")
            if (moneytrans.classList.contains("check-bal-form")) {
                moneytrans.classList.toggle("check-bal-form")
            }
            if (passform.classList.contains("passbook-f")) {
                passform.classList.toggle("passbook-f")
            }
            
        }
    )

    trans.addEventListener("click",
    ()=>{
        moneytrans.classList.toggle("check-bal-form")
        
        if (checkbal.classList.contains("check-bal-form")) {
            checkbal.classList.toggle("check-bal-form")
            
        }
        if (passform.classList.contains("passbook-f")) {
            passform.classList.toggle("passbook-f")
            
        }
        
    }
)

passbook.addEventListener("click",
()=>{
    passform.classList.toggle("passbook-f")
    
    if (checkbal.classList.contains("check-bal-form")) {
        checkbal.classList.toggle("check-bal-form")
        
    }
    if (moneytrans.classList.contains("check-bal-form")) {
        moneytrans.classList.toggle("check-bal-form")
        
    }
    
}
)
