import * as Yup from "yup";

export interface LoginForm {
  name?: string;
  email: string;
  password: string;
  passwordMatch?: string;
}

export const formScheme: LoginForm = {
  name: "",
  email: "",
  password: "",
  passwordMatch: "",
};

export const validationScheme = Yup.object().shape({
  name: Yup.string()
    .trim()
    .required("Name is required!")
    .max(50, "Name has the limit of 50 characters!"),

  email: Yup.string()
    .trim()
    .required("Email is required!")
    .email("Invalid Email!"),

  password: Yup.string()
    .required("Password is required!")
    .min(8, "Password must have at least 8 characters!"),

  passwordMatch: Yup.string().oneOf(
    [Yup.ref("password")],
    "Password must match!"
  ),
});
