class Main {
   constructor() {
     // do preparation
   }

   render() {
        const appContainer = document.querySelector("#app");
        const textElement = document.createElement("div");
        textElement.className = "text";
        textElement.innerHTML = "Hello World";
        appContainer.appendChild(textElement);
   }
}
