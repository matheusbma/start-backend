package com.tenway.start.model;

import org.springframework.data.annotation.Id;

public record Mesa(@Id Integer id, String nome, String status, Integer idLaboratorio) {
}
