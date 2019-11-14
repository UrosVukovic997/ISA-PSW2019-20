$(document).ready(function () {
    $(document).find("#zahteviRegBtn").click(funZahtevi());
    
    function funZahtevi() {
        return function () {
             $("#pageZahtev").show();
        }
    }


});
