$(function () {
    $(".ui-datatable-scrollable-body").css("max-height", $(window).height() - 4 - $(".ui-datatable-scrollable-body").offset().top);
});

$(document).ready(function () {
    $(window).resize(function () {
        $(".ui-datatable-scrollable-body").css("max-height", $(window).height() - 4 - $(".ui-datatable-scrollable-body").offset().top);
    });
});

function actualizar() {
    $(".ui-datatable-scrollable-body").css("max-height", $(window).height() - 4 - $(".ui-datatable-scrollable-body").offset().top);
}