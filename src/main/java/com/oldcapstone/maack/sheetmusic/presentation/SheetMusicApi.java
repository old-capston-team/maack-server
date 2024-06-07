package com.oldcapstone.maack.sheetmusic.presentation;

import com.oldcapstone.maack.common.presentation.ApiResponse;
import com.oldcapstone.maack.sheetmusic.business.SheetMusicService;
import com.oldcapstone.maack.sheetmusic.presentation.dto.SheetMusicResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api/v1/sheet-musics")
@RestController
@RequiredArgsConstructor
public class SheetMusicApi {

    private final SheetMusicService sheetMusicService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<SheetMusicResponseDTO.UploadSheetMusic> addSheetMusic(@RequestParam final MultipartFile file) {
        return ApiResponse.onSuccess(sheetMusicService.addSheetMusic(file));
    }

    @GetMapping("/me")
    public ApiResponse<SheetMusicResponseDTO.MySheetMusicPreViewListDTO> getMySheetMusicList(@RequestParam final Long memberId,
                                                                                             @RequestParam final Integer page){
        return ApiResponse.onSuccess(sheetMusicService.getMySheetMusicList(memberId,(page-1)));
    }

    @GetMapping("/{sheetMusicId}")
    public ApiResponse<SheetMusicResponseDTO.SheetMusicViewResponseDTO> getSheetMusic(@PathVariable(name = "sheetMusicId") final Long sheetMusicId){
        return ApiResponse.onSuccess(sheetMusicService.getSheetMusic(sheetMusicId));
    }

    @GetMapping("/midi/{sheetMusicId}")
    public SheetMusicResponseDTO.MidiFileUrlResponseDTO getMidiFileUrl(@PathVariable(name = "sheetMusicId") final Long sheetMusicId){
        return sheetMusicService.getMidiFileUrl(sheetMusicId);
    }
}
