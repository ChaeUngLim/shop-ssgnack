$(document).ready(function (){

    $("#selectByName").on('keydown', function (event){
        if(event.key === 'Enter'){
            event.preventDefault();

            selectProduct();
        }
    });
    $(".group-div").click(function (){
        selectProduct();
    });

    function selectProduct(){
        location.href = "/stock/search?productName=" + $("#selectByName").val();
    }

})