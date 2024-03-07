"use client";

import { ImageCard, Template } from "@/components";
import { useState } from "react";

export default function GaleriaPage() {
  const image1 =
    "https://www.themoviedb.org/t/p/w533_and_h300_bestv2/yDI6D5ZQh67YU4r2ms8qcSbAviZ.jpg";
  const image2 =
    "https://www.themoviedb.org/t/p/w533_and_h300_bestv2/36LnijfQCOC89rCMOhn2OINXROI.jpg";
  const nome1 = "Titanic";
  const nome2 = "Star Wars";

  const [codigoImage, setCodigoImage] = useState<number>(2);
  const [urlImage, setUrlImage] = useState<string>(image1);
  const [nomeImage, setNomeImage] = useState<string>(nome1);

  function mudarImagem() {
    if (codigoImage == 1) {
      setCodigoImage(2);
      setUrlImage(image2);
      setNomeImage(nome2);
    } else {
      setCodigoImage(1);
      setUrlImage(image1);
      setNomeImage(nome1);
    }
  }

  return (
    <Template>
      <button className="bg-gray-500" onClick={mudarImagem}>
        Clica para mudar
      </button>
      <section className="grid grid-cols-4 gap-8">
        <ImageCard
          nome="Matrix"
          tamanho="10Mb"
          dataUpload="07/03/2024"
          src="https://www.themoviedb.org/t/p/w533_and_h300_bestv2/hv7o3VgfsairBoQFAawgaQ4cR1m.jpg"
        />
        <ImageCard
          nome={nomeImage}
          tamanho="10Mb"
          dataUpload="07/03/2024"
          src={urlImage}
        />
      </section>
    </Template>
  );
}
