document.addEventListener('visibilitychange', function(){
    if (document.hidden) {
        document.title = '快回来吧!'
    }
    else{
        document.title = '欢迎回来!'
    }
})


let username = document.getElementById('username');

// setInterval(function () {
//
//     username.value += 'h'
// },1000)