package org.javaguru.travel.insurance.core.validations;

import org.javaguru.travel.insurance.core.util.ErrorCodeUtil;
import org.javaguru.travel.insurance.dto.ValidationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ValidationErrorFactoryTest {

    @Mock ErrorCodeUtil errorCodeUtil;

    @InjectMocks
    private ValidationErrorFactory factory;

    @Test
    public void shouldReturnValidationErrorWithDescription() {
        when(errorCodeUtil.getErrorDescription("ERROR_CODE"))
                .thenReturn("error description");
        ValidationError error = factory.buildError("ERROR_CODE");
        assertEquals(error.getErrorCode(), "ERROR_CODE");
        assertEquals(error.getDescription(), "error description");
    }

}