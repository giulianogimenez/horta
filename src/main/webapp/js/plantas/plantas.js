$(function(){
    
});

function add(projeto, planta) {
    var botao = "#botao" + planta;
    $(botao + " button").attr('disabled', 'disabled');
    $.getJSON("/horta/adicionarplanta/" + projeto + "/" + planta, function(data){
    }).done(function(data) {
        $(botao + " button").removeAttr('disabled');
        if(data === true) {
            $(botao).html('<button id="btnRemover" type="button" onclick="remover(' + projeto + ',' + planta + ');" class="btn btn-danger"><i class="fa fa-times"></i></button>');
        }
    });
}

function remover(projeto, planta) {
    var botao = "#botao" + planta;
    $(botao + " button").attr('disabled', 'disabled');
    $.getJSON("/horta/removerplanta/" + projeto + "/" + planta, function(data){
    }).done(function(data) {
        $(botao + " button").removeAttr('disabled');
        if(data === true) {
            $(botao).html('<button id="btnAdd" type="button" class="btn btn-primary" onclick="add(' + projeto + ',' + planta + ');" ><i class="fa fa-plus"></i></button>');
        }
    });
}