<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20221222145259 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE SEQUENCE product_translation_id_seq INCREMENT BY 1 MINVALUE 1 START 1');
        $this->addSql('CREATE TABLE product (code VARCHAR(255) NOT NULL, PRIMARY KEY(code))');
        $this->addSql('CREATE TABLE product_translation (id INT NOT NULL, translatable_id VARCHAR(255) DEFAULT NULL, description VARCHAR(255) NOT NULL, locale VARCHAR(5) NOT NULL, PRIMARY KEY(id))');
        $this->addSql('CREATE INDEX IDX_1846DB702C2AC5D3 ON product_translation (translatable_id)');
        $this->addSql('CREATE UNIQUE INDEX product_translation_unique_translation ON product_translation (translatable_id, locale)');
        $this->addSql('ALTER TABLE product_translation ADD CONSTRAINT FK_1846DB702C2AC5D3 FOREIGN KEY (translatable_id) REFERENCES product (code) ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE SCHEMA public');
        $this->addSql('DROP SEQUENCE product_translation_id_seq CASCADE');
        $this->addSql('ALTER TABLE product_translation DROP CONSTRAINT FK_1846DB702C2AC5D3');
        $this->addSql('DROP TABLE product');
        $this->addSql('DROP TABLE product_translation');
    }
}
