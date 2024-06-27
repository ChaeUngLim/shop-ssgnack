$(document).ready(function () {

    $(".product-insert").click(function () {
        window.location.href = "/product/insert";
    });
    $(".product-update").click(function () {
        window.location.href = "/product/update";
    });
    $(".product-delete").click(function () {
        window.location.href = "/product/delete";
    });
    $("#selectByName").on('keydown', function (event) {
        if (event.key === 'Enter') {
            event.preventDefault();

            selectProduct();
        }
    });
    $(".rectangle-parent3").click(function () {
        selectProduct();
    });

    function selectProduct() {
        location.href = "/product/main?productName=" + $("#selectByName").val();
    }

    $(".menu").click(function () {
        window.location.href = "/";
    });

    $("#insertSubmit").click(function () {
        let product = {
            productName: $("#productName").val(),
            price: $("#price").val(),
            company: $("#company").val(),
            category: $("#category").val(),
            orderableStatus: $("#orderableStatus").val()
        }

        if (product.productName == ""
            || product.price == ""
            || product.company == ""
            || product.category == ""
            || product.orderableStatus == ""
        ) {
            alert(" 입력하지 않은 값이 존재합니다 !!");
            return;
        }

        $.ajax({
            url: "/product/insert",
            type: "post",
            contentType: "application/json",
            data: JSON.stringify(product),
            success: function (insertData) {
                let fileInput = $("#fileUpload")[0];
                let file = fileInput.files[0];

                if(file) {
                    let formData = new FormData();
                    formData.append("file",file);

                    $.ajax({
                        url: "/ftp/upload",
                        type: "post",
                        data: formData,
                        contentType: false,
                        processData: false,
                        success: function (uploadData){
                            alert(insertData.msg);
                            window.location.href = insertData.returnURL;
                        },
                        error: function (uploadError){
                            console.log(uploadError);
                            alert("File upload failed!");
                        }
                    });
                }
            },
            error: function (error) {
                console.log(error);
            }
        });
    });

    $("#updateSubmit").click(function () {
        let product = {
            productId: $("#productId").val(),
            price: $("#price").val(),
            company: $("#company").val(),
            category: $("#category").val(),
            orderableStatus: $("#orderableStatus").val()
        }
        let file = $("#fileUpload").val();

        if (product.productName == ""
            || product.price == ""
            || product.company == ""
            || product.category == ""
            || product.orderableStatus == ""
        ) {
            alert(" 입력하지 않은 값이 존재합니다 !!");
            return;
        }

        $.ajax({
            url: "/product/update",
            type: "post",
            contentType: "application/json",
            data: JSON.stringify(product),
            success: function (data) {
                alert(data.msg);

                window.location.href = data.returnURL;
            },
            error: function (error) {
                console.log(error);
            }
        });
    });

    $("#selectRow td").click(function () {

        if(confirm("정말 삭제하시겠습니까?")){
            let productId = $(this).parent().children()[0].innerText;

            if(productId == ""){
                alert(" 입력하지 않은 값이 존재합니다 !!");
                return;
            }

            $.ajax({
                url: "/product/delete",
                type: "post",
                contentType: "text/plain",
                data: productId,
                success: function (data) {
                    alert(data.msg);

                    window.location.href = data.returnURL;
                },
                error: function (error) {
                    console.log(error);
                }
            });

        };
    });

});