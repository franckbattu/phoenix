<?php

namespace App\DataFixtures;

use Doctrine\Bundle\FixturesBundle\Fixture;
use Doctrine\Persistence\ObjectManager;
use App\Entity\Product;

class AppFixtures extends Fixture
{
    public function load(ObjectManager $manager): void
    {
        $product = new Product();
        $product->setCode("123456");
        $product->translate("fr")->setDescription("Appareil photo");
        $product->translate("en")->setDescription("Camera");
        $manager->persist($product);
        $product->mergeNewTranslations();
        $manager->flush();
    }
}
