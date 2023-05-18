// const prevButton = document.getElementById("prev");
//
// prevButton.addEventListener('click', function (event) {
//     event.preventDefault();
//     fetch('https://items-list?page=0&size=2' )
//         .then(response => response.json())
//         .then(data => {
//             const resultAll = document.getElementById('resultNew');
//             resultAll.innerHTML = '';
//
//             data.content.forEach(item => {
//                 const itemNew = document.createElement('div');
//                 itemNew.textContent = item.name;
//                 itemNew.image = item.image;
//                 itemNew.textContent = item.description;
//                 resultAll.appendChild(itemNew);
//             });
//
//             if (data.number() > 0) {
//                 const previousPage = document.createElement('a');
//                 previousPage.href = `/items-list?name=${data.name}&page=${data.number - 1}&size=${data.size}`;
//                 previousPage.textContent = 'Previous';
//                 resultAll.appendChild(previousPage);
//             }
//         })
//         .catch(error => {
//             console.error('Error:', error);
//         });
//
// });
//
//
//
//
// const nextButton = document.getElementById("next");
// nextButton.addEventListener("click", function (event) {
// event.preventDefault();
// const name = document.getElementById('input-find-by-name').value();
//     fetch('https://items-list?page=0&size=2' )
//         .then(response => response.json())
//         .then(data => {
//             const result = document.getElementById('resultNew');
//             result.innerHTML = '';
//
//             data.content.forEach(item => {
//                 const itemNew = document.createElement('div');
//                 itemNew.textContent = item.name;
//                 itemNew.image = item.image;
//                 itemNew.textContent = item.description;
//                 result.appendChild(itemNew);
//             });
//             if (data.number() < data.getTotalLength()){
//                 const nextPage = document.createElement('a');
//                 nextPage.href = `/items-list?name=${data.name}&page=${data.number + 1}&size=${data.size}`;
//                 nextPage.textContent = 'Next';
//                 result.appendChild(nextPage);
//             }
//         })
//         .catch(error => {
//             console.error('Error:', error);
//         });
// })
//

const button = document.getElementById("add-to-cart-button")
