$(document).on("click", "#btnregistrar", function(){
    $("#exampleModalLabel").html("Registrar Especialidad");
    $("#txttitulo").val("");
    $("#txtfuncion").val("");
    $("#txtfechgraduacion").val("");
    $("#hddidespecialidad").val("0");
    cargarCboMedico(0);
    $("#btncerrar").hide();
    $("#modalespecialidad").modal("show");
})

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/especialidad/registro",
        contentType: "application/json",
        data: JSON.stringify({
            titulo: $("#txttitulo").val(),
            funcion: $("#txtfuncion").val(),
            fechgraduacion: $("#txtfechgraduacion").val(),
            idmedico: $("#cbomedico").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarEspecialidades();
                $("#modalespecialidad").modal("hide");
            }
            $("#msjresultado").html("");
            $("#msjresultado").append(
                `<div class="alert alert-success text-center" role="alert">${resultado.mensaje}` +
                `</div>`
            )
        }
    })
})

function cargarCboMedico(idmedico){
    $.ajax({
        type: "GET",
        url: "/medico/lista",
        dataType: "json",
        success: function(resultado){
            $("#cbomedico").empty();
            $.each(resultado, function(index, value){
                $("#cbomedico").append(
                    `<option value="${value.idmedico}">${value.apemedico + ' ' + value.nommedico}</option>`
                )
            });
            if(idmedico > 0){
                $("#cbomedico").val(idmedico);
            }
        }
    })
}

function listarEspecialidades(){
    $.ajax({
        type: "GET",
        url: "/especialidad/lista",
        dataType: "json",
        success: function(resultado){
            $("#tblespecialidad > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblespecialidad > tbody").append(
                    `<tr>` +
                        `<td>${value.medico.apemedico + ' ' + value.medico.nommedico}</td>` +
                        `<td>${value.titulo}</td>` +
                        `<td class="text-center">${value.fechgraduacion}</td>` +
                        `<td class="text-center">` +
                            `<button style="width: 100px" type="button" class="btn btn-success btnleer" ` +
                                     `data-espid="${value.idespecialidad}">Ver` +
                            `</button>` +
                        `</td>` +
                        `<td class="text-center">` +
                            `<button style="width: 100px" type="button" class="btn btn-primary btnactualizar" ` +
                                     `data-espid="${value.idespecialidad}">Actualizar` +
                            `</button>` +
                        `</td>` +
                        `<td class="text-center">` +
                            `<button style="width: 100px" type="button" class="btn btn-danger btneliminar" ` +
                                     `data-espid="${value.idespecialidad}">Eliminar` +
                            `</button>` +
                        `</td>` +
                    `</tr>`
                )
            })
        }
    })
}