interface ButtonProps {
  style?: string;
  label?: string;
  onClick?: (event: any) => void;
}

export const Button: React.FC<ButtonProps> = ({
  style,
  label,
  onClick,
}: ButtonProps) => {
  return (
    <button
      className={`${style} text-white px-4 py-2 rounded-lg 
    hover:text-black  shadow-lg`}
      onClick={onClick}
    >
      {label}
    </button>
  );
};
