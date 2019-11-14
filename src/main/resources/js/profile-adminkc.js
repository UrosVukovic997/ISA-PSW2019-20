$(document).ready(function () {
    $(document).find("#zahteviRegBtn").click(funZahtevi());
    
    function funZahtevi() {
        return function () {
            fillTaleZahtevi();
             $("#pageZahtev").show();
        }
    }

    function fillTaleZahtevi() {

        $.get({
            url: '/api/pacijenti/zahtev',
            success: function (data) {
                $("#pageZahtev").find("table").find("tbody#zahteviTable").empty();
                for (var i = 0; i < data.length; i++) {
                    if (data[i] !== null) {
                        var redovi = '<tr>'
                            + '<th>data.ImePacijenta</th>'
                            + '<th>data.PrezimePacijenta</th>'
                            + '<th>data.E_mail</th>'
                            + '<th>data.JBO</th>'
                            + '<th></th>'
                            + '<th></th>'
                            + '</tr>';
                    }
                }
            },
            error: function () {
                console.log("greska");          }
        });
    }
});
