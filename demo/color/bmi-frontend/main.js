let weightEl = document.querySelector("#weight");
let heightEl = document.querySelector("#height");
let btnGet = document.querySelector("#btn-get");
let btnPost = document.querySelector("#btn-post");

let resultEl = document.querySelector("h2 span");
let descriptionEl = document.querySelector("p span");

btnGet.addEventListener("click", async () => {
    try {
        let weightValue = weightEl.value;
        let heightValue = heightEl.value;

        let res = await axios.get(
            `http://localhost:8080/bmi?weight=${weightValue}&height=${heightValue}`
        );

        displayInfo(res.data);
    } catch (error) {
        console.log(error.response.data.message);
    }
});

btnPost.addEventListener("click", async () => {
    try {
        let weightValue = weightEl.value;
        let heightValue = heightEl.value;

        let res = await axios.post("http://localhost:8080/bmi", {
            weight: weightValue,
            height: heightValue,
        });

        displayInfo(res.data);
    } catch (error) {
        console.log(error.response.data.message);
    }
});

function displayInfo(obj) {
    let bmi = obj.data
    resultEl.innerText = bmi;

    if (bmi < 18.5) {
        descriptionEl.innerText = "Thiếu cân";
    } else if (bmi >= 18.5 && bmi <= 24.9) {
        descriptionEl.innerText = "Bình thường";
    } else if (bmi >= 25 && bmi <= 29.9) {
        descriptionEl.innerText = "Thừa cân";
    } else {
        descriptionEl.innerText = "Béo phì";
    }
}
