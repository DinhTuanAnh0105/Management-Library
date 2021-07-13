package com.example.nhom1_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DsNguoiMuonAdapter  extends BaseAdapter {
    private DsNguoiMuon context;
    private LayoutInflater inflater;
    private ArrayList<DsNguoiMuonClass> listNguoiMuon;
    public DsNguoiMuonAdapter(DsNguoiMuon context,ArrayList<DsNguoiMuonClass> listNguoiMuon) {
        this.context = context;
        this.listNguoiMuon = listNguoiMuon;
    }
    public int getCount() {
        return listNguoiMuon.size();
    }

    @Override
    public Object getItem(int position) {
        return listNguoiMuon.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null)
        {
            inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.row_them_nguoi_muon,null);
        }
        TextView txtMaNM=(TextView)convertView.findViewById(R.id.txtMaNM);
        TextView txtTenNM=(TextView)convertView.findViewById(R.id.txtTenNM);
        TextView txtSdtNM=(TextView)convertView.findViewById(R.id.txtSdtNM);
        ImageView icon_nguoimuon=(ImageView)convertView.findViewById(R.id.icon_nguoimuon);
        ImageView SuaNM=(ImageView)convertView.findViewById(R.id.SuaNM);
        ImageView XoaNM=(ImageView)convertView.findViewById(R.id.XoaNM);
        final DsNguoiMuonClass DsNguoiMuon= listNguoiMuon.get(position);
        txtMaNM.setText(DsNguoiMuon.getMaSv());
        txtTenNM.setText(DsNguoiMuon.getTenSv());
        txtSdtNM.setText(DsNguoiMuon.getLop()+"-"+DsNguoiMuon.getSdt());
        XoaNM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.dialogDeleteSV(DsNguoiMuon.getMaSv());
            }
        });

        SuaNM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.dialogUpdateSV(DsNguoiMuon.getMaSv(), DsNguoiMuon.getTenSv(), DsNguoiMuon.getLop(), DsNguoiMuon.getSdt());
            }
        });
        return convertView;
    }
}
