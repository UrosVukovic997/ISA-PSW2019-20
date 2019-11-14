$('#Registracija').submit(function (event) {
    event.preventDefault();

    var ime=$('#inputIme').val();
    var prezime=$('#inputPrezime').val();
    var email=$('#inputEmail').val();
    var lozinka=$('#inputLozinka').val();
    var lozinka2=$('#Inputpotvrda_lozinke').val();
    var jbo=$('#inputJbo').val();
    var adresa=$('#intputAdresa').val();
    var grad=$('#inputGrad').val();
    var drzava=$('#inputDrzava').val();
    var telefon=$('#inputTelefon').val();


    userData = JSON.stringify({
        ImePacijenta: ime,
        PrezimePacijenta: prezime,
        E_mail: email,
        Lozinka: lozinka,
        lozinka2: lozinka2,
        Adresa: adresa,
        Grad: grad,
        Drzava: drzava,
        BrojTelefona: telefon,
        JBO: jbo

    });

    $.post({
        url: 'TEST/registracija',
        data: userData,
        contentType: 'application/json',
        success: function() {
            alert('Registrovali ste se');

        }, error: function(error) {
            console.log(error);
            alert('Pogresni podaci!');
        }
    });
});