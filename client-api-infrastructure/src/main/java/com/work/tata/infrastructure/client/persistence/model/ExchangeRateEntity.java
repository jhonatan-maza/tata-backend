package com.work.tata.infrastructure.client.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exchangerate")
public class ExchangeRateEntity {
    @Id
    private String base_code;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition="JSON")
    private Map<String, BigDecimal> rates;
}
