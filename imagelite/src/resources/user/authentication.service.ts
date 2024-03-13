import {
  User,
  Credentials,
  AccessToken,
  UserSessionToken,
} from "./users.resources";

class AuthService {
  baseURL: string = "http://localhost:8080/v1/images";
  static AUTH_PARAM: string = "_auth";

  async authenticate(credentials: Credentials): Promise<AccessToken> {
    const response = await fetch(this.baseURL + "/auth", {
      method: "POST",
      body: JSON.stringify(credentials),
      headers: {
        "Content-Type": "application/json",
      },
    });
    if (response.status === 401) {
      throw new Error("User or password are incorrect!");
    }

    return await response.json();
  }
}
