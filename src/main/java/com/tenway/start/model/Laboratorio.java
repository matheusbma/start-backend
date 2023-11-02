package com.tenway.start.model;

import org.springframework.data.annotation.Id;

public record Laboratorio(@Id Integer id, String nome, String status) {
}
