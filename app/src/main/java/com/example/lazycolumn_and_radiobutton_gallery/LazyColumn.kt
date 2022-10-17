package com.example.lazycolumn_and_radiobutton_gallery


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.lazycolumn_and_radiobutton_gallery.ui.theme.Typography
import com.example.lazycolumn_and_radiobutton_gallery.ui.theme.textStyle

@Composable
fun GalleryLazyColumn() {

    var stateItem by remember { mutableStateOf(false) }
    var stateItemImage by remember { mutableStateOf(ItemEnum.Aivazovsky) }

    if (!stateItem) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
//            state = state
        ) {
            items(1) {
                ItemEnum.values().forEach { item ->
                    val state = rememberScrollState(0)
                    Spacer(modifier = Modifier.height(12.dp))
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, color = Color.Cyan),
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(152.dp),
                        elevation = 8.dp
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .selectable(
                                    selected = item.equals(stateItem),
                                    onClick = {
                                        stateItem = !stateItem;
                                        stateItemImage = item
                                    })
                        ) {
                            Image(
                                painter = painterResource(id = item.image),
                                contentDescription = null,
                                modifier = Modifier.size(150.dp),
                                contentScale = ContentScale.Crop
                            )
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(137.dp)
                                    .padding(start = 10.dp, end = 10.dp)
                            ) {
                                Text(
                                    text = stringResource(id = item.author),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(36.dp)
                                        .padding(bottom = 10.dp, top = 10.dp),
                                    style = Typography.textStyle,
                                    color = Color.Black, textAlign = TextAlign.Center
                                )
                                Text(
                                    text = stringResource(id = item.itemDec), modifier = Modifier
                                        .verticalScroll(state)
                                        .fillMaxWidth(), style = Typography.textStyle
                                )
                            }
                        }
                    }
                }
            }
        }
    } else {
        ItemEnum.values().forEach { i ->
            if (stateItemImage == i) RadioButtonFun(
                img = i.Pictures,
                author = i.author,
                info = i.itemDec
            )
        }
    }
}


enum class ItemEnum(val image: Int, val author: Int, val itemDec: Int, val Pictures: List<Int>) {
    Aivazovsky(
        image = R.drawable.aivazovsky,
        author = R.string.aivazovski,
        itemDec = R.string.aivazovski_desc,
        Pictures = listOf(R.drawable.image2, R.drawable.image4, R.drawable.image3)
    ),
    SalvadorDali(
        image = R.drawable.dali,
        author = R.string.salvador,
        itemDec = R.string.salvador_dali,
        Pictures = listOf(R.drawable.daliimg1, R.drawable.daliimg2, R.drawable.daliimg3)
    ),
    VanGogh(
        image = R.drawable.vangogh,
        author = R.string.vanGogh,
        itemDec = R.string.van_gogh,
        Pictures = listOf(R.drawable.vangoghimg3, R.drawable.vangoghimg2, R.drawable.vangoghimg1)
    ),
    PabloPicaso(
        image = R.drawable.picaso,
        author = R.string.picaso,
        itemDec = R.string.pablo_picasso,
        Pictures = listOf(R.drawable.picasoimg1, R.drawable.picasoimg2, R.drawable.picasoimg3)
    ),
    Davinci(
        image = R.drawable.davinci,
        author = R.string.davinci,
        itemDec = R.string.leonardo_da_vinci,
        Pictures = listOf(R.drawable.davinciimg1, R.drawable.davinciimg2, R.drawable.davinciimg3)
    ),
    KlodMone(
        image = R.drawable.klodmone,
        author = R.string.klodMone,
        itemDec = R.string.klod_mone,
        Pictures = listOf(R.drawable.klodimg1, R.drawable.klodimg2, R.drawable.klodimg3)
    ),
    SandroBotticelli(
        image = R.drawable.boticelli,
        author = R.string.sandroBotticelli,
        itemDec = R.string.Sandro_Botticelli,
        Pictures = listOf(
            R.drawable.sandroimg1,
            R.drawable.sandroimg2,
            R.drawable.sandroimg3,
            R.drawable.sandroimg4
        )
    ),
    Michelangelo(
        image = R.drawable.michelangelophoto,
        author = R.string.michelangelo,
        itemDec = R.string.michelangelo_Buonarroti,
        Pictures = listOf(
            R.drawable.michelangeloimg1,
            R.drawable.michelangeloimg2,
            R.drawable.michelangeloimg3
        )
    ),
    Warhole(
        image = R.drawable.warholephoto,
        author = R.string.warholeAndy,
        itemDec = R.string.warhole_Andy,
        Pictures = listOf(R.drawable.warholeimg1, R.drawable.warholeimg2, R.drawable.warholeimg3)
    )

}