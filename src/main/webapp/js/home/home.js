$(function() {
    $("#btnNovo").click(function() {
        window.location = '/horta/meuprojeto';
    });
});

function ir(id) {
    window.location = '/horta/meuprojeto/' + id;
}