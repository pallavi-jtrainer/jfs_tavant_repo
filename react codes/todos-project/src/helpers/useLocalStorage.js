
export const useLocalStorage = (username, password) => {
    //console.log(username);
    localStorage.setItem("username", username);
    localStorage.setItem("password", password);
}