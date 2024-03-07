interface ButtonSVGProps {
  style?: string;
  fill: string;
  viewBox: string;
  stroke: string;
  strokeLinecap: string;
  strokeLinejoin: string;
  strokeWidth: string;
  d: string;
  onClick?: (event: any) => void;
}

export const ButtonSVG: React.FC<ButtonSVGProps> = ({
  style,
  fill,
  viewBox,
  stroke,
  strokeLinecap,
  strokeLinejoin,
  strokeWidth,
  d,
  onClick,
}: ButtonSVGProps) => {
  return (
    <svg
      className={`${style}  text-gray-400  hover:text-black`}
      onClick={onClick}
      fill={fill}
      viewBox={viewBox}
      stroke={stroke}
    >
      <path
        stroke-linecap={strokeLinecap}
        stroke-linejoin={strokeLinejoin}
        stroke-width={strokeWidth}
        d={d}
      />
    </svg>
  );
};
