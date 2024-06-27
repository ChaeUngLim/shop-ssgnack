$(document).ready(function (){

    $("#selectByName").on('keydown', function (event){
        if(event.key === 'Enter'){
            event.preventDefault();

            selectProduct();
        }
    });
    $(".group-child1").click(function (){
        selectProduct();
    });

    function selectProduct(){
        location.href = "/stock/search?productId=" + $("#selectByName").val();
    }

})