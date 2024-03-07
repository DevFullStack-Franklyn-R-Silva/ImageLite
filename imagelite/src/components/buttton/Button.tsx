interface ButtonProps {
  style?: string;
  label?: string;
  onClick?: (event: React.MouseEvent<HTMLButtonElement>) => void;
  type?: "submit" | "reset" | "button" | undefined;
}

export const Button: React.FC<ButtonProps> = ({
  style,
  label,
  onClick,
  type,
}: ButtonProps) => {
  return (
    <button
      className={`${style} text-white px-4 py-2 rounded-lg 
    hover:text-black  shadow-lg`}
      onClick={onClick}
      type={type}
    >
      {label}
    </button>
  );
};
