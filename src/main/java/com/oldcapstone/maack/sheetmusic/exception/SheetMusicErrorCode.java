package com.oldcapstone.maack.sheetmusic.exception;

import com.oldcapstone.maack.common.annotation.ExplainError;
import com.oldcapstone.maack.common.exception.BaseErrorCode;
import com.oldcapstone.maack.common.exception.ErrorReason;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Field;
import java.util.Objects;

import static com.oldcapstone.maack.common.consts.MaackStatic.NOT_FOUND;

@Getter
@AllArgsConstructor
public enum SheetMusicErrorCode implements BaseErrorCode{
    SHEET_MUSIC_NOT_FOUND(NOT_FOUND, "SHEET_MUSIC_404_1", "악보를 찾을 수 없습니다.");

    private final Integer status;
    private final String code;
    private final String reason;

    @Override
    public ErrorReason getErrorReason() {
        return ErrorReason.builder().reason(reason).code(code).status(status).build();
    }

    @Override
    public String getExplainError() throws NoSuchFieldException {
        Field field = this.getClass().getField(this.name());
        ExplainError annotation = field.getAnnotation(ExplainError.class);
        return Objects.nonNull(annotation) ? annotation.value() : this.getReason();
    }
}
