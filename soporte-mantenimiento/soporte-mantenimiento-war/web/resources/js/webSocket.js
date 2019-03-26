function notificacion(message, channel, event) {
    document.getElementById("nombre").innerHTML = message;
    console.log("AAAAAAAAAAAAAAAA")
    mostrar();
    audioNotificacion();
    setTimeout(esconder, 5000);
}

function esconder() {
    PF('bar').hide();
}

function mostrar() {
    PF('bar').show();
}

function audioNotificacion() {
    var audio = new Audio('../resources/audio/notificacionSound.wav');
    var promise = audio.play();
    if (promise !== undefined) {
        promise.then(_ => {
            // Autoplay started!
        }).catch(error => {
            // Autoplay was prevented.
            // Show a "Play" button so that user can start playback.
        });
    }
}