// Promise : Lời hứa

// Hứa : Cuối năm có đủ 40 củ thì mua con Iphone 14 Pro Max

let money = 50;

function buyIphone() {
    return new Promise(function(resolve, reject) {
        if(money >= 40) {
            resolve("Mua iPhone thôi")
        } else {
            reject("Cày tiếp để đủ tiền mua IP")
        }
    })
}

// Hứa tiếp : Mua iPhone còn tiền thì mua con Air Pod (4 tr)
function buyAirPod() {
    return new Promise(function(resolve, reject) {
        if(money - 40 - 4 >= 0) {
            resolve("Mua tiếp air pod")
        } else {
            reject("Không đủ tiền mua air pod")
        }
    })
}

buyIphone()
    .then(res => {
        console.log(res);
        return buyAirPod();
    })
    .then(res1 => {
        console.log(res1);
    })
    .catch(err => {
        console.log(err);
    })
    .finally(() => {
        console.log("Đi nhậu");
    })

// buyIphone()
//     .then(res => {
//         console.log(res);
//     })
//     .catch(err => {
//         console.log(err);
//     })

// buyAirPod()
//     .then(res => {
//         console.log(res);
//     })
//     .catch(err => {
//         console.log(err);
//     })

Promise.all([buyIphone(), buyAirPod()])
    .then(res => console.log(res))
    .catch(err => console.log(err))