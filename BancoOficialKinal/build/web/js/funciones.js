$(document).ready(function () {
    $("tr #btnDelete").click(function () {
        var idp = $(this).parent().find("#idp").val();
        swal({
            title: "Are you sure?",
            text: "Once deleted, you will not be able to recover this imaginary file!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
                .then((willDelete) => {
                    if (willDelete) {
                        swal("Poof! Your imaginary file has been deleted!", {
                            icon: "success",
                        });
                    } else {
                        swal("Your imaginary file is safe!");
                    }
                });
        eliminar(idp);
    });
    function eliminar(idp) {
        var url = "Controlador?menu=BancoTarjetas&accion=Delete";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp=" + idp,
            success: function (data, textStatus, jqXHR) {
                alert("Registro Eliminado");
            }
        })
    }
});


