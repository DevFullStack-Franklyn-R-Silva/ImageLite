interface ButtonSVGProps {
  style?: string;
  fill?: string;
  viewBox?: string;
  stroke?: string;
  strokeLinecap?: "butt" | "round" | "square" | "inherit" | undefined;
  strokeLinejoin?: "miter" | "round" | "bevel" | "inherit" | undefined;
  strokeWidth?: string;
  d?: string;
  onClick?: (event: React.MouseEvent<SVGElement>) => void;
  ariaHidden?: any;
  fillRule?: "inherit" | "nonzero" | "evenodd" | undefined;
  clipRule?: string;
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
  ariaHidden,
  fillRule,
  clipRule,
}: ButtonSVGProps) => {
  return (
    <svg
      className={style}
      onClick={onClick}
      fill={fill}
      viewBox={viewBox}
      stroke={stroke}
      aria-hidden={ariaHidden}
    >
      <path
        strokeLinecap={strokeLinecap}
        strokeLinejoin={strokeLinejoin}
        strokeWidth={strokeWidth}
        d={d}
        fillRule={fillRule}
        clipRule={clipRule}
      />
    </svg>
  );
};
