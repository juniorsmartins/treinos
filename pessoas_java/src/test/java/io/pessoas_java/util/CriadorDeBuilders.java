package io.pessoas_java.util;

import com.github.javafaker.Faker;
import io.pessoas_java.adapters.in.dto.request.PessoaDtoIn;
import io.pessoas_java.adapters.in.dto.request.PessoaEditarDtoIn;
import io.pessoas_java.adapters.out.entity.PessoaEntity;
import io.pessoas_java.application.core.domain.enums.EstadoCivilEnum;
import io.pessoas_java.application.core.domain.enums.NivelEducacionalEnum;
import io.pessoas_java.application.core.domain.enums.SexoEnum;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

public class CriadorDeBuilders {

    public static Faker faker = new Faker();

    public static CpfGenerator cpfGenerator = new CpfGenerator();

    private static Random random = new Random();

    private static SexoEnum sexo;

    private static NivelEducacionalEnum nivelEducacional;

    private static EstadoCivilEnum estadoCivil;

    public static PessoaDtoIn.PessoaDtoInBuilder gerarPessoaDtoInBuilder() {

        return PessoaDtoIn.builder()
            .nome(faker.name().firstName())
            .sobrenome(faker.name().lastName())
            .cpf(cpfGenerator.cpf(false))
            .dataNascimento("01/01/2020")
            .sexo(faker.dog().gender())
            .genero(faker.lorem().characters(5, 10))
            .nivelEducacional("Superior")
            .nacionalidade(faker.lorem().characters(5, 10));
    }

    public static PessoaEditarDtoIn.PessoaEditarDtoInBuilder gerarPessoaEditarDtoInBuilder() {

        return PessoaEditarDtoIn.builder()
                .nome(faker.name().firstName())
                .sobrenome(faker.name().lastName())
                .cpf(cpfGenerator.cpf(false))
                .dataNascimento("01/01/2020")
                .sexo(faker.dog().gender())
                .genero(faker.lorem().characters(5, 10))
                .nivelEducacional("Superior")
                .nacionalidade(faker.lorem().characters(5, 10));
    }

    public static PessoaEntity.PessoaEntityBuilder gerarPessoaEntityBuilder() {

        gerarEnumsAleatorios();

        return PessoaEntity.builder()
            .chave(UUID.randomUUID())
            .nome(faker.name().firstName())
            .sobrenome(faker.name().lastName())
            .cpf(cpfGenerator.cpf(false))
            .dataNascimento(gerarDataNascimentoAleatoria())
            .sexo(sexo)
            .genero(faker.lorem().characters(5, 10))
            .nivelEducacional(nivelEducacional)
            .nacionalidade(faker.lorem().characters(5, 10))
            .estadoCivil(estadoCivil);
    }

    private static void gerarEnumsAleatorios() {
        sexo = SexoEnum.values()[random.nextInt(SexoEnum.values().length)];
        nivelEducacional = NivelEducacionalEnum.values()[random.nextInt(NivelEducacionalEnum.values().length)];
        estadoCivil = EstadoCivilEnum.values()[random.nextInt(EstadoCivilEnum.values().length)];
    }

    private static LocalDate gerarDataNascimentoAleatoria() {

        int minYear = 1950; // Ano mínimo para a data de nascimento
        int maxYear = 2022; // Ano máximo para a data de nascimento

        // Gere um ano aleatório entre minYear e maxYear
        int year = random.nextInt(maxYear - minYear + 1) + minYear;

        // Gere um mês aleatório entre 1 e 12 (janeiro a dezembro)
        int month = random.nextInt(12) + 1;

        // Gere um dia aleatório entre 1 e o máximo de dias no mês e ano gerados
        int maxDay = LocalDate.of(year, month, 1).lengthOfMonth();
        int day = random.nextInt(maxDay) + 1;

        return LocalDate.of(year, month, day);
    }
}

