$(function() {
    $("#btnNovo").click(function() {
        window.location = '/horta/projeto';
    });
});

function ir(id) {
    window.location = '/horta/projeto/planta/' + id;
}