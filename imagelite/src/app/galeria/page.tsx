"use client";

import { ImageCard, Template } from "@/components";
import { Image } from "@/resources/image/image.resource";
import { useImageService } from "@/resources/image/image.service";
import { useState } from "react";

export default function GaleriaPage() {
  const useService = useImageService();
  const [images, setImages] = useState<Image[]>([]);

  async function searchImages() {
    const result = await useService.buscar();
    setImages(result);
    console.table(images);
  }

  return (
    <Template>
      <button className="bg-gray-500" onClick={searchImages}>
        Clica para mudar
      </button>
      <section className="grid grid-cols-4 gap-8">
        <ImageCard
          nome="{nomeImage}"
          tamanho="10Mb"
          dataUpload="07/03/2024"
          src="{urlImage}"
        />
      </section>
    </Template>
  );
}
